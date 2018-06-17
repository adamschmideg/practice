(ns hackerrank.absolute-permutation)

(defn swap [v]
 (let [[a b] (partition (/ (count v) 2) v)]
   (concat b a)))

(defn absolutePermutation [n k]
  (let [nums (mapv inc (range n))]
    (if (zero? k)
      nums
      (if (zero? (rem n (* 2 k)))
        (let [chunks (partition (* 2 k) nums)]
          (first (map swap chunks)))
        -1))))

