use crate::string_matching::Solution;
impl Solution {
    pub fn multi_search(big: String, smalls: Vec<String>) -> Vec<Vec<i32>> {
        let mut vec: Vec<Vec<i32>> = Vec::new();
        for x in smalls {

            if x=="" {
                vec.push(Vec::new());
                break;
            }
            let mut child = Vec::new();
            big.match_indices(&x).for_each(|(i, j)| {
                child.push(i as i32);
            });
            vec.push(child);
        }
        vec
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;
    #[test]
    fn test_multi() {
        let small = vec!["is".to_string(), "ppi".to_string(), "hi".to_string(), "sis".to_string()
                         , "i".to_string(), "ssippi".to_string()];
        let vec1 = Solution::multi_search("mississippi".to_string(), small);
        println!("vec1 = {:?}", vec1);
        assert_eq!(vec1, vec![vec![1, 4], vec![8], vec![], vec![3], vec![1, 4, 7, 10], vec![5]]);
    }
}
