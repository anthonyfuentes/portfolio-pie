(ns portfolio-pie.casting.vanguard
  (:require [portfolio-pie.casting.numbers :refer [->number]]))

(def cast-map
  {:name str
   :ticker str
   :shares ->number
   :share-price ->number
   :total-value ->number})

(defn cast-values [asset [label value]]
  (assoc
    asset
    label
    ((label cast-map) value)))

(defn cast-asset [asset]
  (reduce cast-values {} asset))

(defn cast-assets [assets]
  (map cast-asset assets))
