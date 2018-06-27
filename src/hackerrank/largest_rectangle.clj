(ns hackerrank.largest-rectangle)

(defn greatest-streak [xs n]
  (->> xs
    (map #(if (<= n %) n 0))
    (partition-by zero?)
    (map #(apply + %))
    (apply max)))

(defn largestRectangle [h]
  (apply max
    (map #(greatest-streak h %)
       (range (inc (apply max h))))))
