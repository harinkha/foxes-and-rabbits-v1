package io.muic.ooc.fab;

public class SimulatorViewObserver extends Observable implements Observer{
    @Override
    public void update(int step, Field field) {
        notifyAllObservers(step,field);
    }
}
