public class QueueBank {

    private Turn first;

    private Turn actualTurn;

    private Turn last;

    public Turn getLast() {
        return last;
    }

    public void setLast(Turn last) {
        this.last = last;
    }

    public Turn getFirst() {
        return first;
    }

    public void setFirst(Turn first) {
        this.first = first;
    }

    public Turn getActualTurn() {
        return actualTurn;
    }

    public void setActualTurn(Turn actualTurn) {
        this.actualTurn = actualTurn;
    }

    public void addTurnFirst(int turn){
        Turn turn1 = new Turn(turn);

        if(first == null){
            last = turn1;
        } else {
            first.setPrevious(turn1);
            turn1.setPrevious(last);
            last.setNext(turn1);
        }

        first = turn1;

    }

    public void addTurnLast(){
        Turn turn1;
        if(first == null){
            turn1 = new Turn(1);
            first = turn1;
            actualTurn = turn1;
            last = turn1;
        } else {
            turn1 = new Turn(last.getNumTurn()+1);
            last.setNext(turn1);
            turn1.setPrevious(last);
            turn1.setNext(first);
            first.setPrevious(turn1);
        }

        last = turn1;

    }

    public Turn findTurn(int numTurn, Turn pointer,int n){
        pointer = first;
        n = 0;

        if((pointer != first || n == 0) && pointer.getNumTurn() != numTurn){
            findTurn(numTurn,pointer.getNext(),n+1);
        }

        return pointer;
    }

    public void nextTurn(){
        deleteTurn();
        setActualTurn(actualTurn.getNext());
    }
    public void passTurn(){
        if(actualTurn.getOpportunities()<3){
            actualTurn.setOpportunities();
            actualTurn = actualTurn.getNext();
        }else{
            deleteTurn();
        }
    }

    public void deleteTurn(){
        /*
        if (actualTurn == first) {
            //first.getPrevious().setNext(first.getNext());
            first = first.getNext();
        }else{

        }
        */

        actualTurn.getPrevious().setNext(actualTurn.getNext());
        actualTurn.getNext().setPrevious(actualTurn.getPrevious());

    }


}