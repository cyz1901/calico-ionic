import { resolve } from "path";
import { defineConfig } from "vite";

export default defineConfig({
  resolve: {
    alias: {
      styles: resolve(__dirname, "./sandbox/styles"),
    },
  },
});
