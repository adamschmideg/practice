(ns hackerrank.bigger-is-greater)

(defn next-perm [xs]
  ; xs => [1 2 4 3]
  ; prefix => [1]
  ; pivot => 2
  ; suffix => [4 3]
  ; rev => [3 4 2 1]
  (let [rev (reverse xs)
        suffix (take-while identity
                 (conj
                   (map #(when (<= %1 %2) %2) rev (next rev))
                   (first rev)))
        [pivot & prefix] (drop (count suffix) rev)]
      (when pivot
        (let [[before [new-pivot & after]] (split-with #(< % pivot) suffix)]
          (concat (reverse prefix) [new-pivot] before [pivot] after)))))

(defn permutations [xs]
  (take-while identity (iterate next-perm xs)))

(defn biggerIsGreater [w]
  (next-perm w))

