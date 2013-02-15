(ns pert.core)


(defrecord Task [id dur req])
(defrecord Pert [tasks])

; needs this because of mutual recursion
(declare end-date start-date)

(defn end-date [t]
  (+ (start-date t) (.dur t)))

(defn start-date [t]
  (if (empty? (.req t))
    0
    (max (map end-date (.req t)))))