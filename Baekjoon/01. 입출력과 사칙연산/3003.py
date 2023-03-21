white_piece = input()

king = 1 - int(white_piece.split()[0])
queen = 1 - int(white_piece.split()[1])
rook = 2 - int(white_piece.split()[2])
bishop = 2 - int(white_piece.split()[3])
knight = 2 - int(white_piece.split()[4])
pawn = 8 - int(white_piece.split()[5])

print(king, queen, rook, bishop, knight, pawn)