(ns hackerrank.down-to-zero)

(defn greatest-div [n]
  (let [sqrt (int (Math/sqrt n))
        sqrt (if (= (* sqrt sqrt) n) sqrt (inc sqrt))]
    (filter #(zero? (mod n %))
      (range sqrt n))))

(defn down-to-zero [n]
  (if (zero? n)
    []
    (let [next-nums (into [(dec n)] (greatest-div n))
          down-seq (apply min-key count (map down-to-zero next-nums))]
      (conj down-seq n))))

(defn naive-down-to-zero [n]
  (if (zero? n)
    0
    (inc
      (if-let [div (first (greatest-div n))]
        (naive-down-to-zero div)
        (naive-down-to-zero (dec n))))))

(defn downToZero [n]
  (count (down-to-zero n)))

