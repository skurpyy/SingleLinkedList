public class PrimeLinkedList {

    // Node class for singly linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Singly linked list class
    static class SinglyLinkedList {
        Node head;

        void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        // Sum all nodes in the list
        int sum() {
            int total = 0;
            Node current = head;
            while (current != null) {
                total += current.data;
                current = current.next;
            }
            return total;
        }
    }

    // Check if a number is prime
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Check if number contains digit '3'
    static boolean containsDigitThree(int num) {
        return String.valueOf(num).contains("3");
    }

    public static void main(String[] args) {
        int n = 100; // Change this value as needed, must be < 1,000,000

        SinglyLinkedList primeList = new SinglyLinkedList();
        SinglyLinkedList primesWith3List = new SinglyLinkedList();

        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                primeList.add(i);
                if (containsDigitThree(i)) {
                    primesWith3List.add(i);
                }
            }
        }

        int sum = primesWith3List.sum();
        System.out.println("Sum of primes with digit '3' between 0 and " + n + " = " + sum);
    }
}