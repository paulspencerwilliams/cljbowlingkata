(ns bowlingkata.core)

(defn spare? [first second] (= 10 (+ first second)))
(defn strike? [first] (= "X" first))

(defn score-type [first second]
  (cond
    (strike? first) :strike
    (spare? first second) :spare
    :else :normal))

(defn add-next-if-spare
  [turn-with-next]
  (let [[first-roll second-roll next-roll final-roll] turn-with-next]
    (case (score-type first-roll second-roll)
      :strike (+ 10 10 10)
      :spare (+ first-roll second-roll next-roll)
      :normal (+ first-roll second-roll))))

(defn score
  "Calculate score for a series of rolls"
  [rolls]
  (reduce
    +
    (map add-next-if-spare
         (take 10 (partition 4 2 [0] rolls)))))
