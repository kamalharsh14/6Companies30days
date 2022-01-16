//Problem Link: https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1/

package Day13;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    public void connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        Node nextcurr;
        q.add(root);
        while (!q.isEmpty()) {
            nextcurr = null;
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (i == 0) {
                    nextcurr = curr;
                } else {
                    nextcurr.nextRight = curr;
                    nextcurr = curr;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node nextRight;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        nextRight = null;
    }
}