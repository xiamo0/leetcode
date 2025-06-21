use crate::binary_tree::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;

struct Solution;
impl Solution {
    pub fn get_minimum_difference(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut vec = Vec::new();
        Self::travese(root, &mut vec);
        let mut min = i32::MAX;
        for i in 1..vec.len() {
            let diff = (vec[i] - vec[i - 1]).abs();

            min = std::cmp::min(min, diff);
        }
        min
    }
    fn travese(node: Option<Rc<RefCell<TreeNode>>>, vec: &mut Vec<i32>) {
        if let Some(node) = node {
            let left_clone = node.borrow().left.clone();
            Self::travese(left_clone, vec);
            vec.push(node.borrow().val);
            let right_clone = node.borrow().right.clone();
            Self::travese(right_clone, vec);
        }
    }
}
#[cfg(test)]
mod tests {
    use crate::binary_tree::minimum_absolute_difference_in_bst::Solution;
    use crate::binary_tree::tree_node::TreeNode;
    use std::cell::RefCell;
    use std::rc::Rc;

    #[test]
    fn test_get_minimum_difference() {
        let left_node = Some(Rc::new(RefCell::new(TreeNode {
            val: 1,
            left: None,
            right: None,
        })));
        let tree = Some(Rc::new(RefCell::new(TreeNode {
            val: 2,
            left: left_node,
            right: None,
        })));
        let min = Solution::get_minimum_difference(tree);
        format!("{}", min);
        assert_eq!(1, min);
    }
}
