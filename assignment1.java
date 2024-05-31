public class assignment1 {
    // Task class
    static class Task {
        private String title;
        private String description;
        private boolean completed;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false; // By default, tasks are not completed
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            this.completed = true;
        }
    }

    // Node class
    static class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }

        public Task getTask() {
            return task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // ToDoList class
    static class ToDoList {
        private Node head;

        public ToDoList() {
            this.head = null;
        }

        public void addToDo(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

        public void markToDoAsCompleted(String title) {
            Node current = head;
            while (current != null) {
                if (current.getTask().getTitle().equals(title)) {
                    current.getTask().markCompleted();
                    return;
                }
                current = current.getNext();
            }
            System.out.println("Task with title '" + title + "' not found.");
        }

        public void viewToDoList() {
            Node current = head;
            System.out.println("To-Do List:");
            while (current != null) {
                Task task = current.getTask();
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                System.out.println("-----------------------");
                current = current.getNext();
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        // Adding tasks to the to-do list
        toDoList.addToDo(new Task("Buy Grocery", "Buy groceries for the week"));
        toDoList.addToDo(new Task("Do Assignment", "Complete the Java assignment"));

        // Marking a task as completed
        toDoList.markToDoAsCompleted("Buy Grocery");

        // Viewing the to-do list
        toDoList.viewToDoList();
    }
}
