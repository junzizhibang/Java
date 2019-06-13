package malin.algrithrim;

/******************************************** 
 * 模块名称: 工作三年经验，目标是成为JAVA高级开发攻城狮/Java 架构师我在努力！我能行！
 * 功能说明: 俩年迷惘期，回首时才发现自己想要的目标和清晰的职业规划
 * 开发人员: 马琳-君子自强，脚踏实地积累 
 * 开发时间:2019/6/13 21:32  今年一定要成为Java高级开发攻城狮 
 * v1.0.0.0 2019/6/13-01  [malin.algrithrim]  1217575485@qq.com        
 * 初始版本基础夯实积攒Java架构师的基础内容  Ideal
 *******************************************/

/**
 * 功能说明：二叉树的  先序遍历.中序遍历/后序遍历
 *
 * @date 2019年5月15日
 * @author 马琳-君子自强，脚踏实地积累
 * @email 1217575485@qq.com
 *
 */
public class NodeTree {
    int data; // 根节点数据
    NodeTree left; // 左子树
    NodeTree right; // 右子树

    public NodeTree() {
        super();
    }

    public NodeTree(int data) { // 实例化二叉树
        super();
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(NodeTree root, int data) {
        if (data > root.data) { // 如果插入的节点大于跟节点
            if (root.right == null) { // 如果右子树为空，就插入，如果不为空就再创建一个节点
                root.right = new NodeTree(data); // 就把插入的节点放在右边
            } else {
                this.insert(root.right, data);
            }
        } else { // 如果插入的节点小于根节点
            if (root.left == null) { // 如果左子树为空，就插入，如果不为空就再创建一个节点
                root.left = new NodeTree(data); // 就把插入的节点放在左边边
            } else {
                this.insert(root.left, data);
            }
        }
    }

    public static void preOrder(NodeTree root) { // 先根遍历
        if (root != null) {
            System.out.print(root.data + "-");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(NodeTree root) { // 中根遍历

        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "--");
            inOrder(root.right);
        }
    }

    public static void postOrder(NodeTree root) { // 后根遍历

        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "---");
        }
    }

    public static void main(String[] args) {
        int[] array = { 3,14,7,1,8,5,11,17,13,6,23,12,20,26,4,16,18,24,25,19,9,10,15,27,28,2  };
        NodeTree root = new NodeTree(array[0]); // 创建二叉树
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]); // 向二叉树中插入数据
        }
        System.out.println("先根遍历：");
        preOrder(root);
        System.out.println();
        System.out.println("中根遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后根遍历：");
        postOrder(root);

    }

}


