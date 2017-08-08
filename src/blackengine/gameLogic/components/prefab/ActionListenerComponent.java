/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackengine.gameLogic.components.prefab;

import blackengine.gameLogic.Entity;
import blackengine.gameLogic.components.base.ComponentBase;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action2;
import rx.functions.Func1;

/**
 * An implementation of this component class will be able to listen to input
 * through the presented observable. It is not required to register this component
 * to the {@link blackengine.gameLogic.LogicEngine LogicEngine}, as the
 * {@link blackengine.gameLogic.components.base.ComponentBase#update() update()}
 * method implementation is empty.
 *
 * On {@link #activate() activate()} the observable will be subscribed to.
 *
 * On {@link #deactivate() deactivate()} the subscription will be canceled.
 *
 * @author Blackened
 * @param <T> Extends Object and should be the type of notifications sent by the
 * observable presented in the constructor.
 */
public class ActionListenerComponent<T extends Object> extends ComponentBase {

    /**
     * A function that returns true for all input actions that are checked in
     * the action.
     */
    private final Func1<T, Boolean> filter;

    /**
     * The action that will be performed on the parent entity when an input
     * action is received that passed through the filter.
     */
    private final Action2<T, Entity> action;

    /**
     * The observable that will be subscribed to using the filter and action.
     */
    private final Observable<T> inputActionObservable;

    /**
     * The subscription to the observable. Only present when this component is
     * activated.
     */
    private Subscription subscription;

    /**
     * Default constructor for creating a new instance of
     * ActionListenerComponent.
     *
     * @param inputActionObservable An implementation of Observable&lt;T&gt;.
     * @param filter A function that returns true for all input actions that are
     * checked in the action.
     * @param action The action that will be performed on the parent entity when
     * an input action is received that passed through the filter.
     */
    public ActionListenerComponent(Observable inputActionObservable, Func1<T, Boolean> filter, Action2<T, Entity> action) {
        this.filter = filter;
        this.action = action;
        this.inputActionObservable = this.castObservable(inputActionObservable);
    }

    /**
     * Casts the observable to an observable of type T.
     *
     * @param obs The observable to be cast.
     * @return An instance of Observable<T>.
     */
    @SuppressWarnings("unchecked")
    private Observable<T> castObservable(Observable obs) {
        return (Observable<T>) obs;
    }

    /**
     * Handles the input action by calling the action with the parent and action
     * as parameters.
     *
     * @param inputAction The received input action.
     */
    private void handleInput(T inputAction) {
        this.action.call(inputAction, this.getParent());
    }

    /**
     * Activates the component by subscribing to the filtered observable and
     * calling the super implementation of
     * {@link blackengine.gameLogic.components.base.ComponentBase#activate() activate()}.
     */
    @Override
    public void activate() {
        this.subscription = inputActionObservable
                .filter(filter)
                .subscribe(x -> this.handleInput(x));
        super.activate();
    }

    /**
     * Deactivates the component by unsubscribing to the observable and calling
     * the super implementation of
     * {@link blackengine.gameLogic.components.base.ComponentBase#deactivate() deactivate()}.
     */
    @Override
    public void deactivate() {
        this.subscription.unsubscribe();
        super.deactivate();
    }

    /**
     * This implementation of the
     * {@link blackengine.gameLogic.components.base.ComponentBase#update() update()}
     * is empty, and will not have to be called each frame.
     */
    @Override
    public void update() {
    }

}
