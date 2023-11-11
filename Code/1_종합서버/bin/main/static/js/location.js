// main.js 파일에 저장된 코드

// Canvas 요소와 PGM 이미지 URL을 가져옵니다.
const canvas = new fabric.Canvas('slam');
const pgmImageURL = 'URL_TO_PGM_FILE.pgm';

// PGM 이미지를 로드하고 Canvas에 추가합니다.
fabric.Image.fromURL(pgmImageURL, (img) => {
    img.scaleToWidth(canvas.width);
    img.scaleToHeight(canvas.height);
    canvas.add(img);
});