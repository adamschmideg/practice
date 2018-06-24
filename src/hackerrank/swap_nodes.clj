(ns hackerrank.swap-nodes)

(defn add-node [tree open-paths saved-paths node]
  (if node
    (let [last-level (dec (count saved-paths))
          path (get-in open-paths [last-level 0])
          last-level (if path last-level (inc last-level))
          path (if path path (get-in open-paths [last-level 0]))
          tree-out (assoc-in tree (conj path :val) node)
          open-paths-out (update-in open-paths [last-level] #(subvec % 1))
          new-paths [(conj path :left) (conj path :right)]
          open-paths-out (update-in open-paths-out
                                    [(inc last-level)]
                                    #(if %
                                       (into % new-paths)
                                       new-paths))
          saved-paths-out (update-in saved-paths [last-level] #(conj % path))]
      [tree-out open-paths-out saved-paths-out])))

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
