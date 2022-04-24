package geekbang.tree;

/**
 * 二叉搜索树
 * @author xiongwenwen
 * @since 2022/4/24 10:37 上午
 */
public class BinarySearchTree {
    private Node tree;

    public Node find(int data){
        Node p = tree;
        while(null != p){
            if(data < p.data){
                p = p.left;
            }else if(data > p.data){
                p = p.right;
            }else{
                return p;
            }
        }
        return null;
    }

    public void insert(int data){
        if(null == tree){
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while(null != p){
            if(data < p.data){
                if(null == p.left){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }else {
               if(null == p.right){
                   p.right = new Node(data);
                   return;
               }
               p = p.right;
            }
        }
    }

    public void remove(int data){
        //p指向要删除的节点，初始化指向根节点
        Node p = tree;
        // pp记录的是p的父节点
        Node pp = null;
        //查找要删除的节点
        while (p != null && p.data != data){
            pp = p;
            if(data > p.data) p = p.right;
            else p = p.left;
        }
        if(p == null) return;

        /**
         * 删除的节点有两个子节点
         */
        if(p.left != null && p.right != null){
            //查找右子树的最小节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null){
                minPP = minP;
                minP = minP.left;
            }

            // 将minP的数据替换到p中
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        /**
         * 删除的节点只有一个节点
         */
        Node child;
        if(p.left != null) child = p.left;
        else if(p.right != null) child = p.right;
        else child = null;

        /**
         * 删除节点是根节点
         */
        if(pp == null) tree = child;
        else if(pp.left == p) pp.left = child;
        else pp.right = child;
    }


    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
