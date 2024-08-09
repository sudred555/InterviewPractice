class Solution{
  
  class TreeNode {
    int val;
    TreeNode[] children;
    TreeNode(int v, int size){ 
      this.val = v; 
      this.children = new TreeNode[size]; 
    }
  }
  
  private String serialization(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serialization(root, sb);
    if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }
  
  private void serialization(TreeNode node, StringBuilder sb){
    if(node == null) return;
    sb.append(node.val + "#" + node.children.length + ",");
    for(TreeNode n : node.children){
      serialization(n, sb);
    }
    return;
  }
  
  private TreeNode deserialization(String str){
    String[] strs = str.split(",");
    LinkedList<String> list = new LinkedList<>();
    for(String s: strs) list.add(s);
      return deserialization(list);
  }
	
  private TreeNode deserialization(LinkedList<String> list){
    String str = list.removeFirst();
    String[] s = str.split("#");
    TreeNode node = new TreeNode(
      Integer.valueOf(s[0]),
      Integer.valueOf(s[1]));
    for(int i = 0; i < node.children.length; i++){
      node.children[i] = deserialization(list);
    }
    return node;
  }
}
