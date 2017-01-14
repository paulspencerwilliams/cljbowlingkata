(ns bowlingkata.core)

(defn spare? [first second] (= 10 (+ first second)))

(defn add-next-if-spare
  [turn-with-next]
  (let [[first-roll second-roll next-roll] turn-with-next]
    (if (spare? first-roll second-roll)
      (+ first-roll second-roll next-roll)
      (+ first-roll second-roll))))

(defn score
  "Calculate score for a series of rolls"
  [rolls]
  (reduce
    +
    (map add-next-if-spare
         (take 10 (partition 3 2 [0] rolls)))))
