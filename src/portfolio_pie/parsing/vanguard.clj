(ns portfolio-pie.parsing.vanguard
  (:require [portfolio-pie.csv.vanguard :refer [vectorize]]
            [portfolio-pie.filtering.vanguard :refer [select-assets]]
            [portfolio-pie.casting.vanguard :refer [cast-assets]] ))

(def labels
  [:name :symbol :shares :share-price :total-value])

(defn label-asset [asset]
  (zipmap labels asset))

(defn label-assets [assets]
  (map label-asset assets))

(defn parse-assets [filepath]
  (-> filepath
      vectorize
      select-assets
      label-assets
      cast-assets))
