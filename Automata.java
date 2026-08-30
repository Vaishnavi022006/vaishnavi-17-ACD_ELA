import java.util.*;

public class Automata {

    // ---------------- DFA ----------------
    static void dfa() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter DFA input string (0/1): ");
        String input = sc.nextLine();

        String state = "q0";

        for (char ch : input.toCharArray()) {

            if (state.equals("q0")) {
                if (ch == '0')
                    state = "q0";
                else if (ch == '1')
                    state = "q1";
                else {
                    System.out.println("Invalid input");
                    return;
                }
            }

            else if (state.equals("q1")) {
                if (ch == '0')
                    state = "q0";
                else if (ch == '1')
                    state = "q1";
                else {
                    System.out.println("Invalid input");
                    return;
                }
            }
        }

        if (state.equals("q1"))
            System.out.println("DFA: String Accepted");
        else
            System.out.println("DFA: String Rejected");
    }


    // ---------------- NFA ----------------
    static void nfa() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter NFA input string (0/1): ");
        String input = sc.nextLine();

        // NFA transition table
        Map<String, Map<Character, Set<String>>> transition =
                new HashMap<>();

        transition.put("q0", new HashMap<>());
        transition.put("q1", new HashMap<>());
        transition.put("q2", new HashMap<>());

        // q0 --0--> q0,q1
        transition.get("q0").put('0',
                new HashSet<>(Arrays.asList("q0", "q1")));

        // q0 --1--> q0
        transition.get("q0").put('1',
                new HashSet<>(Arrays.asList("q0")));

        // q1 --1--> q2
        transition.get("q1").put('1',
                new HashSet<>(Arrays.asList("q2")));

        // q2 --0--> q2
        transition.get("q2").put('0',
                new HashSet<>(Arrays.asList("q2")));

        Set<String> currentStates = new HashSet<>();
        currentStates.add("q0");

        for (char ch : input.toCharArray()) {

            Set<String> nextStates = new HashSet<>();

            for (String state : currentStates) {

                if (transition.containsKey(state) &&
                    transition.get(state).containsKey(ch)) {

                    nextStates.addAll(
                        transition.get(state).get(ch)
                    );
                }
            }

            currentStates = nextStates;
        }

        // q2 is final state
        if (currentStates.contains("q2"))
            System.out.println("NFA: String Accepted");
        else
            System.out.println("NFA: String Rejected");
    }


    // ---------------- NFA TO DFA ----------------
    static void nfaToDfa() {

        Scanner sc = new Scanner(System.in);

        // NFA transition table
        Map<String, Map<Character, Set<String>>> nfa =
                new HashMap<>();

        nfa.put("q0", new HashMap<>());
        nfa.put("q1", new HashMap<>());
        nfa.put("q2", new HashMap<>());

        nfa.get("q0").put('0',
                new HashSet<>(Arrays.asList("q0", "q1")));

        nfa.get("q0").put('1',
                new HashSet<>(Arrays.asList("q0")));

        nfa.get("q1").put('1',
                new HashSet<>(Arrays.asList("q2")));

        nfa.get("q2").put('0',
                new HashSet<>(Arrays.asList("q2")));

        char[] alphabet = {'0', '1'};

        Set<Set<String>> dfaStates = new HashSet<>();

        Queue<Set<String>> queue = new LinkedList<>();

        // DFA start state = {q0}
        Set<String> start = new HashSet<>();
        start.add("q0");

        dfaStates.add(start);
        queue.add(start);

        System.out.println("\nNFA to DFA Conversion");
        System.out.println("---------------------");

        while (!queue.isEmpty()) {

            Set<String> current = queue.poll();

            System.out.println("\nDFA State: " + current);

            for (char symbol : alphabet) {

                Set<String> next = new HashSet<>();

                // Find all possible NFA destinations
                for (String state : current) {

                    if (nfa.containsKey(state) &&
                        nfa.get(state).containsKey(symbol)) {

                        next.addAll(
                            nfa.get(state).get(symbol)
                        );
                    }
                }

                System.out.println(
                    current + " --" + symbol + "--> " + next
                );

                // New DFA state found
                if (!dfaStates.contains(next)) {

                    dfaStates.add(next);
                    queue.add(next);
                }
            }
        }

        System.out.println("\nDFA States:");
        for (Set<String> state : dfaStates) {
            System.out.println(state);
        }

        System.out.println("\nConversion Completed!");
    }


    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==========================");
            System.out.println("      AUTOMATA PROGRAM");
            System.out.println("==========================");

            System.out.println("1. DFA");
            System.out.println("2. NFA");
            System.out.println("3. NFA to DFA");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    dfa();
                    break;

                case 2:
                    nfa();
                    break;

                case 3:
                    nfaToDfa();
                    break;

                case 4:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
