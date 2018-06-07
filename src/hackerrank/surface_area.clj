(ns hackerrank.surface-area)

(defn surfaces [times all]
  (if (empty? all)
    0
    (* times (apply + all))))

(defn surfaceArea [A]
  (let [total (flatten A)
        z-axis (map #(max 0 (dec %)) (flatten A))
        x-axis (mapcat #(map min % (next %)) A)
        y-axis (mapcat #(map min % (next %)) (apply map vector A))]
    (- (surfaces 6 total)
       (surfaces 2 x-axis)
       (surfaces 2 y-axis)
       (surfaces 2 z-axis))))
