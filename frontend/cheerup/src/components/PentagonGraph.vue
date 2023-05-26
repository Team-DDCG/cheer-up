<template>
    <div>
      <canvas ref="canvas" width="150" height="150"></canvas>
    </div>
  </template>
  
  <script>
  export default {
    mounted() {
      console.log("pentagon-graph mounted");
      this.drawPentagonGraphs();
    },
    methods: {
        drawPentagonGraphs() {
            const canvas = this.$refs.canvas;
            const context = canvas.getContext('2d');

            const centerX = canvas.width / 2;
            const centerY = canvas.height / 2;
            const radius = Math.min(centerX, centerY) - 10;

            context.clearRect(0, 0, canvas.width, canvas.height);

            this.drawPentagonGraph(context, centerX, centerY, radius, this.data, 2, '#A46CFF'); // First graph with red color
            // this.data = [1,1,1,1,1];
            this.drawPentagonGraph(context, centerX, centerY, radius, [1,1,1,1,1], 0.5, 'white'); // Second graph with blue color
            this.drawPentagonGraph(context, centerX, centerY, radius, [0.8,0.8,0.8,0.8,0.8], 0.5, 'white'); // Second graph with blue color
            this.drawPentagonGraph(context, centerX, centerY, radius, [0.6,0.6,0.6,0.6,0.6], 0.5, 'white'); // Second graph with blue color
            this.drawPentagonGraph(context, centerX, centerY, radius, [0.4,0.4,0.4,0.4,0.4], 0.5, 'white'); // Second graph with blue color
            this.drawPentagonGraph(context, centerX, centerY, radius, [0.2,0.2,0.2,0.2,0.2], 0.5, 'white'); // Second graph with blue color
            },
        drawPentagonGraph(context, centerX, centerY, radius, data, lineWidth, color) {
            context.beginPath();
            for (let i = 0; i < 5; i++) {
                const angle = (Math.PI * 2 / 5) * i - Math.PI / 2;
                const x = centerX + Math.cos(angle) * radius * data[i];
                const y = centerY + Math.sin(angle) * radius * data[i];

                if (i === 0) {
                context.moveTo(x, y);
                } else {
                context.lineTo(x, y);
                }
            }
            context.closePath();

            context.lineWidth = lineWidth;
            context.strokeStyle = color; // Graph line color
            //   context.fillStyle = '#f00'; // Graph fill color
            context.stroke();
            //   context.fill();
        }
    },
    props: {
      data: {
        type: Array,
        required: true
      }
    },
    watch: {
      data: {
        handler() {
          // data가 변경될 때 수행할 동작
          this.drawPentagonGraphs();
        },
        deep: true // 중첩된 배열의 변경까지 감지하도록 설정
      }
},
  };
  </script>
  