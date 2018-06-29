(ns hackerrank.down-to-zero)

(defn greatest-div [n]
  (let [sqrt (int (Math/sqrt n))
        sqrt (if (= (* sqrt sqrt) n) sqrt (inc sqrt))]
    (filter #(zero? (mod n %))
      (range sqrt n))))

(defn downToZero [n]
  (if (zero? n)
    0
    (let [next-nums (into [(dec n)] (greatest-div n))]
      (inc (apply min (map downToZero next-nums))))))


