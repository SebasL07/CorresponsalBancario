public class Turn {

    private int numTurn;
    private int opportunities;

    private Turn next;
    private Turn previous;


    public int getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(int opportunities) {
        this.opportunities = opportunities;
    }

    public int getNumTurn() {
        return numTurn;
    }

    public void setNumTurn(int numTurn) {
        this.numTurn = numTurn;
    }

    public Turn getNext() {
        return next;
    }

    public void setNext(Turn next) {
        this.next = next;
    }

    public Turn getPrevious() {
        return previous;
    }

    public void setPrevious(Turn previous) {
        this.previous = previous;
    }

    public Turn(int numTurn) {
        this.numTurn = numTurn;
    }
}