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
                            (update-in saved-paths
                                       [last-level]
                                       #(if %
                                          (conj % path)
                                          [path]))
                            saved-paths)]
      [tree-out open-paths-out saved-paths-out]))

(defn parse-tree [nodes]
  (let [init [{:val 1}
              [[[:left] [:right]]]
              []]
        f (fn [[tree open-paths saved-paths] node]
            (add-node tree open-paths saved-paths node))
        [tree open-paths saved-paths] (reduce f init nodes)]
    [tree open-paths (into [[[]]] saved-paths)]))

(defn assoc-dissoc-in [m ks v]
  (if (nil? v)
    (let [parent-path (butlast ks)
          parent (get-in m parent-path)]
      (assoc-in m parent-path (dissoc parent (last ks))))
    (assoc-in m ks v)))

(defn swap-at [tree path]
  (let [left-path (conj path :left)
        right-path (conj path :right)
        left (get-in tree left-path)
        right (get-in tree right-path)]
    (-> tree
        (assoc-dissoc-in left-path right)
        (assoc-dissoc-in right-path left))))

(defn swap-nodes-at [tree paths level]
  (reduce swap-at tree (get paths level)))

(defn traverse-in-order [tree]
  (if tree
    (->  (traverse-in-order (:left tree))
      (into [(:val tree)])
      (into (traverse-in-order (:right tree))))
    []))

(defn swapNodes [indexes queries])
