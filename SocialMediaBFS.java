import java.util.*;

public class SocialMediaBFS {

    static void bfs(List<List<Integer>> graph,
                    int start,
                    String[] users) {

        boolean visited[] =
                new boolean[graph.size()];

        Queue<Integer> queue =
                new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int user = queue.poll();

            System.out.println(users[user]);

            for (int friend : graph.get(user)) {

                if (!visited[friend]) {

                    visited[friend] = true;
                    queue.add(friend);
                }
            }
        }
    }

    public static void main(String[] args) {

        String users[] = {
                "Girish",
                "Rahul",
                "Sneha",
                "Arjun",
                "Keerthi",
                "Manoj",
                "Priya",
                "Kiran",
                "Anjali",
                "Varun"
        };

        int V = users.length;

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(5);
        graph.get(2).add(6);

        graph.get(3).add(7);

        graph.get(4).add(8);

        graph.get(5).add(9);

        System.out.println("========================================");
        System.out.println(" SOCIAL MEDIA FRIEND RECOMMENDATION");
        System.out.println("========================================");

        System.out.println("\nUsers Reachable from Girish:\n");

        bfs(graph, 0, users);

        System.out.println("\nRecommendation Status : ACTIVE");
    }
}