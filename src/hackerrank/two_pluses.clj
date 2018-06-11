(ns hackerrank.two-pluses)

(defn all-good? [grid coords]
  (every? (fn [[x y]] (= \G (get-in grid [x y]))) coords))

(defn pluses [grid x y]
  (->> (range) ; [0 1 2 ...]
       (map #(set [[(+ x %) y] [(- x %) y] [x (+ y %)] [x (- y %)]]))
       (take-while #(all-good? grid %))
       (reductions clojure.set/union)))

(defn twoPluses [grid]
  (let [all-pluses (apply concat
                     (for [i (range (count grid))
                           j (range (count (first grid)))]
                       (pluses grid i j)))]
    (apply max
      (for [p1 all-pluses
            p2 all-pluses
            :when (empty? (clojure.set/intersection p1 p2))]
        (* (count p1) (count p2))))))
