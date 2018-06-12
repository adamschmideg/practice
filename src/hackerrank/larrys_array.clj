(ns hackerrank.larrys-array)

(defn rotate [v i]
  (let [a (get v i)
        b (get v (dec i))
        c (get v (- i 2))]
        ; [a b c] => [b c a]
       (-> v
           (assoc i b)
           (assoc (dec i) c)
           (assoc (- i 2) a))))

(defn move-and-drop-greatest [v]
  (let [greatest (count v)
        i (.indexOf v greatest)]
    (cond
      (zero? i) (subvec v 1)
      (= i 1) (recur (-> v
                         (rotate 2)
                         (rotate 2)))
      :else (recur (rotate v i)))))

(defn larrysArray [A]
  (loop [v (vector (reverse A))]
    (condp = (count v)
      0 true
      1 true
      2 (= v [2 1])
      (recur (move-and-drop-greatest v)))))
