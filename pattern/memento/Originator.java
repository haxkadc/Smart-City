package pattern.memento;
 
public class Originator {
 
    private Object originatorState;
 
    public void setOriginatorState(Object state) {
        originatorState = state;
    }
 
    public Object getOriginatorState() {
        return originatorState;
    }
 
    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setMementoState( originatorState );
        return memento;
    }
 
    public void restoreMemento(Memento memento) {
        originatorState = memento.getMementoState();
    }
 
    public class Memento {
 
        private Object mementoState;
 
        private Object getMementoState() {
            return this.mementoState;
        }
 
        private void setMementoState(Object originatorState) {
            this.mementoState = originatorState;
        }
    }
}