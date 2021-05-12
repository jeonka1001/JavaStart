
public class BinaryTree {
	private Node root;
	
	public boolean add(int value) {
		return add(new Node(value,null,null));
	}
	public void searchNode(Node node) {
		if(node == null) {
			return ;
		}
		
		searchNode(node.getLeft());
		System.out.print(node.getValue()+" ");
		searchNode(node.getRight());
		
	}
	public void searchStart() {
		searchNode(root);
	}
	
	
	public boolean add(Node node) {
		if(root == null) {
			root = node;
			System.out.println(root.getValue()+"노드로 저장.");
			return true;
		}
		else {
			while(true) {
				Node curNode = root;
				Node preNode = curNode;
				while(curNode !=null) {
					preNode = curNode;
					if(curNode.getValue()>node.getValue()) {
						curNode = curNode.getLeft();
					}
					else if(curNode.getValue() < node.getValue()) {
						curNode = curNode. getRight();
					}
					else {
						System.out.println("동일 값이 존재하므로 저장 실패");
						return false;
					}
				}
				if(node.getValue() < preNode.getValue()) {
					preNode.setLeft(node);
					System.out.println(preNode.getValue()+"노드의 좌측 자식으로 저장.");
				}else {
					preNode.setRight(node);
					System.out.println(preNode.getValue()+"노드의 우측 자식으로 저장.");
				}
				return true;
			}
		}
	}
}
