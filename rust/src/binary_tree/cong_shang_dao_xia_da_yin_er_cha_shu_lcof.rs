use std::cell::RefCell;
use std::collections::LinkedList;
use std::rc::Rc;
pub struct Solution {}
impl Solution {
    fn decorate_record(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut list = LinkedList::new();
        let mut result: Vec<i32> = Vec::new();
        if let Some(node) = root {
            list.push_back(node);
        }
        while let Some(node) = list.pop_front() {
            let node_ref = node.borrow();
            result.push(node_ref.val);
            if let Some(left) = &node_ref.left {
                let rc1 = left.clone();
                list.push_back(rc1);
            }
            if let Some(right) = &node_ref.right {
                let rc2 = right.clone();
                list.push_back(rc2);
            }
        }

        result
    }
}

#[derive(Debug, PartialEq, Eq)]
struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {}
#[cfg(test)]
mod tests {
    use crate::binary_tree::cong_shang_dao_xia_da_yin_er_cha_shu_lcof::{Solution, TreeNode};
    use std::cell::RefCell;
    use std::rc::Rc;

    #[test]
    fn test() {
        let root = Some(Rc::new(RefCell::new(TreeNode {
            val: 2,
            left: None,
            right: None,
        })));
        let record = Solution::decorate_record(root);
        assert_eq!(record, vec![2]);
    }
}
