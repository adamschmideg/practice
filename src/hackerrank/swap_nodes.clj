(ns hackerrank.swap-nodes)

; a vector of :left and :right
(defn next-path [path]
  (let [i (.lastIndexOf path :left)]
    (if (= i -1)
      (into [:right] (repeat (count path) :left))
      (vec
        (concat
          (subvec path 0 i)
          [:right]
          (repeat (- (count path) i 1) :left))))))

(defn next-existing-path [tree path]
  (->> (iterate next-path path)
    (drop-while #(get-in tree (butlast %)))))

; return [tree path nodes]
(defn parse-tree [tree path nodes]
  (let [[head & tail] nodes]
    (if head
      (let [value (if (= -1 head) nil head)
            tree (assoc-in tree path value)
            path (next-existing-path tree path)]
        (recur tree path tail))
      [tree path []])))

(defn swapNodes [indexes queries])
