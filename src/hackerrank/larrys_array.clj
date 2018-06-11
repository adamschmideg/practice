(ns hackerrank.larrys-array)

(defn rotate [v i]
  (let [a (get v (dec i))
        b (get v i)
        c (get v (inc i))]
        ; [a b c] => [b c a]
       (-> v
           (assoc (dec i) b)
           (assoc i c)
           (assoc (inc i) a))))

(defn move-and-drop-greatest [v]
  (let [greatest (count v)
        i (.indexOf v greatest)]
    (if (zero? i)
      (subvec v 1)
      (recur (rotate v i)))))

(defn larrysArray [A]
  (loop [v (vector (reverse A))]
    (condp = (count v)
      0 true
      1 true
      2 (= v [2 1])
      (recur (move-and-drop-greatest v)))))
