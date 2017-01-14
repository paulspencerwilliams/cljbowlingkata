(ns bowlingkata.core)

(defn spare? [roll] (= \/ roll))
(defn strike? [roll] (= \X roll))

(defn turn-type [head next]
  (cond
    (strike? head) :strike
    (spare? next) :spare
    :else :normal))

(defn turn-score [first second third]
  (cond
    (strike? first) (+ first second third)
    (spare? second) (+ 10 third)
    :else (+ first second)))

(defn roll-score [roll]
  (case roll
    \X 10
    \- 0
    (read-string (str roll))))

(defn score
  "Calculate score for a series of rolls"
  [rolls]
  (loop [[head next after-next & tail :as all] rolls
         acc 0
         turn 0]
    (if (< turn 10)
      (if
        (= (turn-type head next) :strike)
        (recur
          (conj tail next after-next)
          (+ acc (+ 10 (roll-score next) (roll-score after-next)))
          (inc turn))
        (recur
          (conj tail after-next)
          (+ acc
             (if (= (turn-type head next) :spare)
               (+ 10 (roll-score after-next))
               (+ (roll-score head) (roll-score next))))
          (inc turn)))
      acc))
  )


