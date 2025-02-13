package org.example;

public class PQList implements PriorityQueue{

    private Node head;
   private Node tail;
   Node priority;
   private int length;

/**
 * Default Constructor of PQList **/
    PQList() {
        this.length = 0;
    }


    /**
     * Deep copy constructor of parameter, other keyword represents the new list that is being copied.
     * **/
    PQList(PQList other) {
        /**
         * starts off with an empty list
         **/
        this.head = null;
        this.tail = null;
        this.length = 0;
        this.priority = null;

        if (other.head == null) {
            return;  // If the other list is empty, no need to copy
        }
        Node current = other.head; // Start from the head of the original list
        while (current != null) {
            // Create a deep copy of the Player
            Player copiedPlayer = current.data.createClone();

            // Add copied player to the new list
            this.add(copiedPlayer);
            current = current.next; // Move to the next node
        }
    }

    /**
     * Clone method that returns a deep copy of the current instance.
     * **/
    public PQList createClone() {
      return new PQList(this);
    }



    /**
     * This method creates adds a new player at tail.
     * **/
    @Override
    public void add(Player a) {
        Node newNode = new Node(a);

        if(tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }


    /**
     * This method searches through the list, and returns the highest score. **/
    private void searchHighScore() {
        if(head == null) {
            priority = null;
            return;
        }

       int highScore = 0;
        Node current = head;
        priority = null;
        /**
         * Traverse through the linked list, and if the current Node's data
         * is greater than the highScore, set the highScore to the current Node's data
         * and make the currentNode the priority. **/
        while (current != null) {
                if(current.data.getScore() > highScore) {
                    highScore = current.data.getScore();
                    priority = current;
                }
                current = current.next;
        }
    }

    @Override
    public Player getHighestScorePlayer() {
        searchHighScore();
        Node current = head;

        if(priority == null) {
            return null;
        }

        Player highestScorePlayer = priority.data;

        if(priority == head) {
            head = head.next;
            if(head == null) {
                tail = null;
            }
            length--;
            return highestScorePlayer;
        }

        while (current.next != null && current.next != priority) {
            current = current.next;
        }


        if (current.next == priority) {
            current.next = priority.next; // Remove the node
            if (priority == tail) {
                tail = current; // Update tail if we removed the last node
            }
        }

        length--;
        return highestScorePlayer;

//        while (current != null) {
//            if(current.next == priority) {
//                current.next = priority.next;
//                return priority.data;
//            }
//        }
        //return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        priority = null;
        length = 0;
    }

    /**
     * getSize method returns the number of players being stored in the priority queue.
     * **/
    @Override
    public  int getSize() {
        return length;
    }

    /**
     * Checks if the list is empty
     * @return
     */
    @Override
    public boolean isEmpty() {
      return length == 0;
    }


}
