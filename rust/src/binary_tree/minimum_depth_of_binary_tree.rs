use crate::binary_tree::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;
struct Solution {}
impl Solution {
    pub fn min_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut r = 0;
        if let Some(node) = root {
            let node = node.borrow();
            if node.left.is_none() {
                return Self::min_depth(node.right.clone()) + 1;
            }
            if node.right.is_none() {
                return Self::min_depth(node.left.clone()) + 1;
            }
            let i = Self::min_depth(node.left.clone()) + 1;
            let j = Self::min_depth(node.right.clone()) + 1;
            r = if i > j { j } else { i };
        }
        r
    }
}

#[cfg(test)]
mod tests {
    use crate::binary_tree::minimum_depth_of_binary_tree::Solution;
    use crate::binary_tree::tree_node::TreeNode;
    use std::cell::RefCell;
    use std::rc::Rc;

    #[test]
    fn test() {
        let left = Some(Rc::new(RefCell::new(TreeNode::new(2))));
        let root = Some(Rc::new(RefCell::new(TreeNode {
            val: 1,
            left: left,
            right: None,
        })));
        let i = Solution::min_depth(root);
        println!("i={}", i);
        assert_eq!(i, 2);
    }
}
