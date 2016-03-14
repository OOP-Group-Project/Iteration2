package Main.Model.Map;

import Main.Model.Occupation.Sneak;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Michael on 3/12/16.
 */
public class PathFinder {
    private ArrayList closed = new ArrayList();
    private SortedList open = new SortedList();
    private Map map;
    private int maxSearchDistance;
    private Node[][] nodes;
    private Heuristic heuristic;

    public PathFinder(Map map, int maxSearchDistance) {
        this(map, maxSearchDistance, new Heuristic());
    }

    public PathFinder(Map map, int maxSearchDistance, Heuristic heuristic) {
        this.heuristic = heuristic;
        this.map = map;
        this.maxSearchDistance = maxSearchDistance;

        nodes = new Node[map.getWidth()][map.getHeight()];
        for (int x=0;x<map.getWidth();x++) {
            for (int y=0;y<map.getHeight();y++) {
                nodes[x][y] = new Node(x,y);
            }
        }
    }

    public Path findPath(int sx, int sy, int tx, int ty) {
        // easy first check, if the destination is blocked, we can't get there

        if (map.isBlocked( tx, ty)) {
            return null;
        }

        // initial state for A*. The closed group is empty. Only the starting

        // tile is in the open list and it'e're already there
        nodes[sx][sy].cost = 0;
        nodes[sx][sy].depth = 0;
        closed.clear();
        open.clear();
        open.add(nodes[sx][sy]);

        nodes[tx][ty].parent = null;

        // while we haven'n't exceeded our max search depth
        int maxDepth = 0;

        // check if there is sneak
        map.getTile(tx,tx).getEntity().getType() == Sneak
        while ((maxDepth < maxSearchDistance) && (open.size() != 0)) {
            // pull out the first node in our open list, this is determined to

            // be the most likely to be the next step based on our heuristic

            Node current = getFirstInOpen();
            if (current == nodes[tx][ty]) {
                break;
            }

            removeFromOpen(current);
            addToClosed(current);

            // search through all the neighbours of the current node evaluating

            // them as next steps

            for (int x=-1;x<2;x++) {
                for (int y=-1;y<2;y++) {
                    // not a neighbour, its the current tile

                    if ((x == 0) && (y == 0)) {
                        continue;
                    }

                    // determine the location of the neighbour and evaluate it

                    int xp = x + current.x;
                    int yp = y + current.y;

                    //check for invalid cases for even columns
                    if (current.x % 2 == 0){
                        // (-1, -1) case for even columns
                        if ((current.x - xp) == -1 && (current.y - yp) == -1){
                            continue;
                        }
                        // (1, -1) case for even columns
                        if ((current.x - xp) == 1 && (current.y - yp) == -1){
                            continue;
                        }
                    //check for invalid cases for odd columns
                    }else{
                        // (-1, 1) case for odd columns
                        if ((current.x - xp) == -1 && (current.y - yp) == 1){
                            continue;
                        }
                        // (1, 1) case for odd columns
                        if ((current.x - xp) == 1 && (current.y - yp) == 1){
                            continue;
                        }
                    }

                    if (isValidLocation(sx, sy, xp, yp)) {
                        // the cost to get to this node is cost the current plus the movement

                        // cost to reach this node. Note that the heursitic value is only used

                        // in the sorted open list

                        float nextStepCost = current.cost + getMovementCost(current.x, current.y, xp, yp);
                        Node neighbour = nodes[xp][yp];
                        map.pathFinderVisited(xp, yp);

                        // if the new cost we've determined for this node is lower than

                        // it has been previously makes sure the node hasn'e've
                        // determined that there might have been a better path to get to

                        // this node so it needs to be re-evaluated

                        if (nextStepCost < neighbour.cost) {
                            if (inOpenList(neighbour)) {
                                removeFromOpen(neighbour);
                            }
                            if (inClosedList(neighbour)) {
                                removeFromClosed(neighbour);
                            }
                        }

                        // if the node hasn't already been processed and discarded then

                        // reset it's cost to our current cost and add it as a next possible

                        // step (i.e. to the open list)

                        if (!inOpenList(neighbour) && !(inClosedList(neighbour))) {
                            neighbour.cost = nextStepCost;
                            neighbour.heuristic = getHeuristicCost(xp, yp, tx, ty);
                            maxDepth = Math.max(maxDepth, neighbour.setParent(current));
                            addToOpen(neighbour);
                        }
                    }
                }
            }
        }

        // since we'e've run out of search
        // there was no path. Just return null

        if (nodes[tx][ty].parent == null) {
            return null;
        }

        // At this point we've definitely found a path so we can uses the parent

        // references of the nodes to find out way from the target location back

        // to the start recording the nodes on the way.

        Path path = new Path();
        Node target = nodes[tx][ty];
        while (target != nodes[sx][sy]) {
            path.prependStep(target.x, target.y);
            target = target.parent;
        }
        path.prependStep(sx,sy);

        // thats it, we have our path

        return path;
    }

    protected Node getFirstInOpen() {
        return (Node) open.first();
    }


    protected void addToOpen(Node node) {
        open.add(node);
    }

    protected boolean inOpenList(Node node) {
        return open.contains(node);
    }

    protected void removeFromOpen(Node node) {
        open.remove(node);
    }

    protected void addToClosed(Node node) {
        closed.add(node);
    }

    protected boolean inClosedList(Node node) {
        return closed.contains(node);
    }


    protected void removeFromClosed(Node node) {
        closed.remove(node);
    }

    protected boolean isValidLocation( int sx, int sy, int x, int y) {
        boolean invalid = (x < 0) || (y < 0) || (x >= map.getWidth()) || (y >= map.getHeight());

        if ((!invalid) && ((sx != x) || (sy != y))) {
            invalid = map.isBlocked(x, y);
        }
        return !invalid;
    }

    public float getMovementCost(int sx, int sy, int tx, int ty) {
        return map.getCost(sx, sy, tx, ty);
    }

    public float getHeuristicCost(int x, int y, int tx, int ty) {
        return heuristic.getCost(map, x, y, tx, ty);
    }

    private class SortedList {
        private ArrayList list = new ArrayList();

        public Object first() {
            return list.get(0);
        }

        public void clear() {
            list.clear();
        }

        public void add(Object o) {
            list.add(o);
            Collections.sort(list);
        }

        public void remove(Object o) {
            list.remove(o);
        }

        public int size() {
            return list.size();
        }

        public boolean contains(Object o) {
            return list.contains(o);
        }
    }


    private class Node implements Comparable {
        private int x;
        private int y;
        private float cost;
        private Node parent;
        private float heuristic;
        private int depth;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int setParent(Node parent) {
            depth = parent.depth + 1;
            this.parent = parent;

            return depth;
        }

        public int compareTo(Object other) {
            Node o = (Node) other;

            float f = heuristic + cost;
            float of = o.heuristic + o.cost;

            if (f < of) {
                return -1;
            } else if (f > of) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}