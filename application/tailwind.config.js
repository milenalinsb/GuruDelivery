/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,jsx}", "./node_modules/flowbite/**/*.js"],
  theme: {
    extend: {},
    colors: {
      "primary": "#FB9400",
      "primary-light": "#fa9e1d",
      "surface": "#FFF",
      "background": "#F9F9FB",
      "on-primary": "#FFF",
      "on-surface": "#000"

    },
    fontFamily:{
      sans: ['Inter', 'sans-serif']
    },
    fontWeight: {
      bold: 600
    }    
  },
  plugins: [require('flowbite/plugin')],
}