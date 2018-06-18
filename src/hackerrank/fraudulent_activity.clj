(ns hackerrank.fraudulent-activity)

(defn insertion-point [i]
  (if (neg? i) (* -1 (inc i)) i))

(defn insert-into-sorted [xs x]
  (let [loc (insertion-point (java.util.Collections/binarySearch xs x))
        before (subvec xs 0 loc)
        after (subvec xs loc)]
    (-> before
      (into [x])
      (into after))))

(defn remove-from-sorted [xs x]
  (let [loc (insertion-point (java.util.Collections/binarySearch xs x))
        before (subvec xs 0 loc)
        after (subvec xs (inc loc))]
    (into before after)))

(defn median-of-sorted [sorted]
  (let [c (count sorted)
        half (quot c 2)]
    (if (odd? c)
      (get sorted half)
      (/ (+ (get sorted half) (get sorted (dec half))) 2))))

(defn median [v]
  (median-of-sorted (vec (sort v))))

(defn remove-insert [sorted [remove insert]]
  (-> (vec sorted)
      (remove-from-sorted remove)
      (insert-into-sorted insert)))

; Complete the activityNotifications function below.
(defn activityNotifications [expenditure d]
  (let [trailing (partition d 1 expenditure)
        check (drop d expenditure)
        sorted (vec (sort (take d expenditure)))
        new (map #(vector %1 %2) expenditure (drop d expenditure))
        sorted-chunks (reductions remove-insert sorted new)
        medians (map median-of-sorted sorted-chunks)
        warnings (map (fn [m c] (<= (* 2 m) c)) medians check)]
    (count (filter identity warnings))))

