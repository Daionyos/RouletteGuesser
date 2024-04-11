public class number {
    private int numberVal;
    private number next;

    public number(int a, number b){
        numberVal = a;  // Assign to the instance variable, not a local variable
        next = b;
    }
    public int getNext(int x) {
        number current = this;  // Start from the current object
        int count = 0;
    
        while (current != null && count < x) {
            current = current.next;  // Move to the next object
            count++;
        }
    
        if (current != null) {
            return current.getValue();
        } else {
            // If x positions away is beyond the end of the list, return -1 or some appropriate value
            return -1;
        }
    }
    
    public number(int a){
        numberVal = a;  // Assign to the instance variable, not a local variable
        next = null;
    }

    public void setNext(number next){
        this.next = next;
    }

    public double getRotate(number result){
        int count = 0;
        number current = this;  // Start from the current object
        while (current != null) {
            if (current.getValue() == result.getValue()) {
                return (double)count/37;
            } else {
                count++;
                current = current.next;  // Move to the next object
            }
        }
        return -1;  // If result is not found, return -1 or some appropriate value
    }

    public int getValue(){
        return numberVal;
    }
}
