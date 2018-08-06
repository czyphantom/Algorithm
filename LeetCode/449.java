/**
 * 题目：设计一个算法来序列化和反序列化二叉搜索树。
 * 难度：Medium
 * 思路：使用前序遍历。
 */

public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        serialHelper(root, sb);
        return sb.toString();
    }

    private void serialHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(',');
            return;
        }

        sb.append(node.val).append(',');
        serialHelper(node.left, sb);
        serialHelper(node.right, sb);
    }

    private int index = 0;

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.charAt(0) == ',') {
            return null;
        }
        return deserialHelper(data);
    }

    private TreeNode deserialHelper(String data) {
        if (',' == data.charAt(this.index)) {
            this.index++;
            return null;
        }

        int comma = data.indexOf(',', this.index);
        String str = data.substring(index, comma);
        this.index = comma + 1;
        int value = Integer.parseInt(str);

        TreeNode node = new TreeNode(value);
        node.left = deserialHelper(data);
        node.right = deserialHelper(data);
        return node;
    }
}