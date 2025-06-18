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

#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}
#[cfg(test)]
mod tests {
    use crate::binary_tree::minimum_depth_of_binary_tree::{Solution, TreeNode};
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
        assert_eq!(Solution::min_depth(root), 3);
    }
}
