(ns scramblies.apis.resources.scramble)

(defn scramble?
  "Return true if a portion of `s1` can be rearranged to match `s2`."
  [s1 s2]
  (if (and s1 s2)
    (let [cs1 (seq (.toLowerCase s1))
          cs2 (seq (.toLowerCase s2))]
      (every? (set cs1) cs2))
    false))
