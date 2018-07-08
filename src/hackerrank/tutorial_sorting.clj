(ns hackerrank.tutorial-sorting)

(defn insert [xs n x]
  (let [[before after] (split-at n xs)]
    (-> (vec before)
      (into [x])
      (into (vec after)))))

(defn find-or-duplicate [xs n elem]
  (let [pivot (get xs n)]
    (println xs n elem pivot)
    (if (< elem pivot)
      [false (insert xs n pivot)]
      [true (insert xs (inc n) elem)])))


(defn insertionSort1 [_ arr]
  (let [[x & xs] (reverse arr)
        v (vec xs)
        inserted (map #(find-or-duplicate v % x) (range))]
    inserted))
