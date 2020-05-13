(ns portfolio-pie.filtering.vanguard)

(defn is-buffer-row? [index row]
  (when (empty? row) index))

(defn get-buffer-indices [rows]
  (keep-indexed is-buffer-row? rows))

(defn get-buffer-start [rows]
  (first (get-buffer-indices rows)))

(defn select-assets [rows]
  (subvec (vec rows) 1 (get-buffer-start rows)))
