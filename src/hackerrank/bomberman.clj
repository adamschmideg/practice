(ns hackerrank.bomberman)

(defn replace-grid [replacement grid]
  (map (fn [row]
         (map replacement row))
       grid))

(defn explode-and-plant [grid]
  (->>
    (for [r (range (count grid))
          c (range (count (first grid)))
          :let [neighbors
                (for [i [-1 0 1]
                      j [-1 0 1]
                      :when (or (zero? i) (zero? j))]
                  (get-in grid [(+ r i) (+ c j)]))]]
        (apply max (or (seq (remove nil? neighbors)) [0])))
    (map #(- 1 %))
    (partition (count (first grid)))))

(defn stringify [grid]
  (clojure.string/join "\n" (map #(apply str %) grid)))

(defn numbered-bomberman [n grid]
  (if (odd? n)
    (->> grid
         (iterate explode-and-plant)
         (drop (dec (/ n 2)))
         first)
    (repeat (count grid) (repeat (count (first grid)) 1))))

(defn flexible-bomberman [n grid transform]
    (->> grid
      (replace-grid {\. 0, \0 1})
      (transform n)
      (replace-grid {0 \., 1 \0})
      stringify))

(defn bomberMan [n grid]
  (flexible-bomberman n grid numbered-bomberman))
