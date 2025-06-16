use std::rc::Rc;
use std::cell::RefCell;
struct Solution;
impl Solution {
    pub fn min_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let r=0;
        if let Some(node) = root {

        }
        return r;
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
    #[test]
    fn test() {
        let root = Some(Rc::new(RefCell::new(TreeNode { 1 })));
        assert_eq!(Solution::min_depth(root), 1);
    }
}