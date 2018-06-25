(ns hackerrank.swap-nodes)

(defn add-node [tree open-paths saved-paths node]
    (let [last-level (dec (count saved-paths))
          path (get-in open-paths [last-level 0])
          last-level (if path last-level (inc last-level))
          path (if path path (get-in open-paths [last-level 0]))
          tree-out (if node
                     (assoc-in tree (conj path :val) node)
                     tree)
          open-paths-out (update-in open-paths [last-level] #(subvec % 1))
          new-paths [(conj path :left) (conj path :right)]
          open-paths-out (if node
                           (update-in open-paths-out
                                    [(inc last-level)]
                                    #(if %
                                       (into % new-paths)
                                       new-paths))
                           open-paths-out)
          saved-paths-out (if node
                            (update-in saved-paths [last-level] #(conj % path))
                            saved-paths)]
      [tree-out open-paths-out saved-paths-out]))

(defn parse-tree [nodes]
  (let [init [{:val 1}
              [[[:left] [:right]]]
              []]
        f (fn [[tree open-paths saved-paths] node]
            (add-node tree open-paths saved-paths node))]
    (reduce f init nodes)))

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


(defn swapNodes [indexes queries])
