# In order to add a new State class, a couple of things have to be done.

In this example, we'll be adding InventoryState, which comes up when you want to view your inventory.

1)  Add the new State (InventoryState)
    a)  Create the class: Add an InventoryState class that extends State. (Name should be something like InventoryState.java)
    b)  Add teh InventoryState class to the StateEnum: If this is a new state that doesn't exist in the StateEnum (like InventoryState), add the name of the state to the end of the StateEnum.
    c)  Add any relevant state information to the new InventoryState class:  If you need to keep track of things like the current selection or the selections that are available to the user, this is the place for them.
    d)  Go into the Model class (Model.java) and after the comment on line 31 about creating all the states, add and instantiate an object of your InventoryState to the states object by adding another put() command with your state (like the other ones)

2)  Add a controller for the new State
    a)  In the Controller.StateControllers package, add a new class for your new state. (i.e. InventoryStateController)
    b)  Make InventoryStateController extend StateController and override the necessary methods (update and handleAction)
    c)  Add the InventoryStateContorller to the controller manager: Go into StateControllerManager.java and add a line to the bottom of the initializeControllers() method.  It should look like all the others there.

3)  Add a Viewport for the new State
    a)  In the View.Renderers.StateViewports package, add a new viewport class for your InventoryState that extends StateViewport (i.e. InventoryStateViewport)
    b)  Make it override the render() method, and provide a non-default constructor that receives a Viewport object "viewport" and calls super(viewport).  (See other state viewports for examples).
    c)  Add the InventoryState viewport to the main Viewport object: go to Viewport.java and in the instantiateViewports() method, add a line that put()s (and instantiates) your new InventoryStateViewport into the stateViewports object.

4)  Make it possible to get into your new state
    a) In order to enter into your new state, you have to go into the state controller that should have control before your state (InventoryState) should have control.  In this case, that would probably be the PlayState.
    b) In the handleAction(Action action) method, add a case for when the action "Inventory" is sent.  If this action doesn't exist, then add it to the UserActionEnum inside the Controller.Manager class.  Also, add a keyboardActionMap entry in the KeyManager class and add a default in for it in the setDefaultKeyActions() method.
    c) In the play state, add a case for the Inventory action, and use the stateControllerManager object to stateControllerManager.setState(StateEnum.InventoryState)

     Now your state will begin executing, you'll have control over it, and it will be rendered to the screen!
sal